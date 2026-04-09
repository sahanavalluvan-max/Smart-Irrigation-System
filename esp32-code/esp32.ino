
#include <WiFi.h>
#include <HTTPClient.h>

const char* ssid = "YOUR_WIFI";
const char* password = "YOUR_PASSWORD";
const char* server = "http://YOUR_IP:8080/api/sensor";

int moisturePin = 34;
int relayPin = 5;

void setup() {
  Serial.begin(115200);
  WiFi.begin(ssid, password);
  pinMode(relayPin, OUTPUT);

  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Connecting...");
  }
}

void loop() {
  int moistureValue = analogRead(moisturePin);
  float moisture = map(moistureValue, 0, 4095, 0, 100);

  float temp = 30.0;
  float humidity = 60.0;

  if (WiFi.status() == WL_CONNECTED) {
    HTTPClient http;

    String url = String(server) +
      "?moisture=" + moisture +
      "&temp=" + temp +
      "&humidity=" + humidity;

    http.begin(url);
    int httpResponseCode = http.POST("");

    if (httpResponseCode > 0) {
      if (moisture < 30) {
        digitalWrite(relayPin, HIGH);
      } else {
        digitalWrite(relayPin, LOW);
      }
    }

    http.end();
  }

  delay(5000);
}
