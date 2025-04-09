📦 nikita-lab-microservices-eureka/
│
├── 🧠 eureka-server               (Сервер регистрации и обнаружения сервисов)
│   └── port: 8761
│   └── Не регистрируется сам, но другие регистрируются в нём
│
├── 🧍 user-service               (Микросервис пользователей)
│   └── port: random (0)
│   └── REST API:
│       └── GET /api/users
│       └── POST /api/users
│   └── Подключен к Eureka (Eureka Client)
│   └── Подключен к MySQL
│
├── 🚪 api-gateway                (Входная точка в систему, маршрутизатор)
│   └── port: 8080
│   └── Роутит запросы:
│       └── /api/users/**  →  lb://user-service
│   └── Подключен к Eureka (Eureka Client)
│   └── Включена CORS-конфигурация (разрешены запросы с фронта)
│
├── 🌐 frontend                  (Nginx + HTML + JS)
│   └── port: 80 (контейнер)
│   └── index.html
│   └── script.js (fetch-запросы к API Gateway)
│   └── style.css
│   └── dockerized
│


✅ Настоящая микросервисная архитектура
✅ Сервисы разделены и общаются через Eureka + API Gateway
✅ Фронт — изолирован и общается с системой через HTTP-запросы
✅ Хранилище — MySQL
✅ Backend не зависит от фронта (и наоборот)
✅ Можно масштабировать каждый сервис отдельно (!!!)


[Frontend] → [API Gateway] → [user-service]
                             → [order-service]
                             → [product-service]

                         ↑
                 [Eureka Server]
