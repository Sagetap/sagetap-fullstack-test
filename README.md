# Sagetap Fullstack Test

Welcome to the Sagetap Fullstack Technical Challenge! This test is designed to evaluate your ability to work across the stack using PostgreSQL, Kotlin, and React.

The local municipality needs your help to deal with the recent influx of shelter kitties. A mysterious shortage of catnip sent all cats scrambling into shelters to demand more, overwhelming the staff.
Your task is to build a small system to manage pet listings and adoptions.

## 🧰 Tech Stack

- **Backend:** Kotlin
- **Frontend:** React (TypeScript)
- **Database:** PostgreSQL
- **Containerization:** Docker

## 📁 Project Structure

```bash
sagetap-fullstack-test/
├── backend/                     # Kotlin backend code
├── frontend/                    # React frontend code
├── database/                    # SQL seed and migration files
│   └── pg_db_init_scripts/      # Scripts to initialize the Postgres DB
├── docker-compose.yml           # Docker orchestration
└── README.md                    # You're here!
```

## 🚀 Getting Started

To simplify the setup process, we’ve included a `docker-compose.yml` to get your local environment running quickly.

```bash
docker compose up --build
```

This will:

- Start a PostgreSQL database
- Seed it with some starting data (this happens automatically)

This is a monorepo and should be treated as such.
Meaning launching the backend and frontend should be done from the root of the repository.

### 🎨 Front-End

Open the repository in your editor of choice and to run the React frontend, executing the following commands

```bash
cd frontend
npm install
npm run dev
```

### ⚙️ Back-End

Make sure you have [Intellij](https://www.jetbrains.com/idea/download/) installed along with [Java 21](https://www.oracle.com/java/technologies/downloads/).

1. Open Intellij
2. File -> Open -> Select the sagetap-fullstack-test directory

It should at this point automatically load the gradle script.
In the top right you should see a little Elephant followed by 'Run the server', click the green play button next to it to start the backend server.

## ✅ Objective

- Update the app to support the following features:
  - Each kitty should have a **detail page** where you can update:
    - Name
    - Age
    - Breed
    - Photo URL
    - Adoption Status (`new_arrival`, `pending_adoption`, `adopted`)
      - This field is currently not supported
  - You should be able to from the list view:
    - **Retrieve lists of kitties** based on their status
    - **Delete kitty listings** from the **list view**
    - **Add a new kitty** from the **list view**
  - If you need to extend the database at all to support these operations, store your sql commands in extend_script.sql
