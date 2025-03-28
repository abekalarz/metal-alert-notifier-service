#!/bin/bash

BACKEND_HOST="http://localhost:8080"
BASE_URL="${BACKEND_HOST}/api/v1/templates"

echo "Wysyłam 3 template'y do backendu..."

curl -X POST "$BASE_URL" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Cena złota szaleje !",
    "content": "Cena złota przekroczyła wartość graniczną !",
    "recipients": ["andrzej@gmail.com", "anna@gmail.com"],
    "rules": {
      "item": {
        "operator": "IS",
        "value": "GOLD"
      },
      "price": {
        "GTE": "1350.00",
        "LT": "1400.00"
      }
    }
  }'

echo -e "\n---\n"

curl -X POST "$BASE_URL" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Srebro rekordowo tanie od roku!",
    "content": "Srebro najtańsze od roku !",
    "recipients": ["janina@gmail.com", "grażyna@gmail.copm"],
    "rules": {
      "item": {
        "operator": "IS_NOT",
        "value": "SILVER"
      },
      "price": {
        "LT": "59.99"
      }
    }
  }'

echo -e "\n---\n"

curl -X POST "$BASE_URL" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Srebro niebezpiecznie tanie!",
    "content": "Uwaga ! Srebro bardzo tanie!",
    "recipients": ["ktoś@gmail.com", "nikt@gmail.com"],
    "rules": {
      "item": {
        "operator": "IS",
        "value": "SILVER"
      },
      "price": {
        "LT": "60.00",
        "GTE": "46.50"
      }
    }
  }'

echo -e "\nWysłano wszystkie dane."
