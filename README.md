# 🏫 Shaale-Vikas

> **A School-Alumni Bridge** — Connecting rural schools with their alumni network to fund and fulfill micro-needs in real time.

[![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?logo=android&logoColor=white)](https://developer.android.com)
[![Language](https://img.shields.io/badge/Language-Kotlin-7F52FF?logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Backend](https://img.shields.io/badge/Backend-Firebase-FFCA28?logo=firebase&logoColor=black)](https://firebase.google.com)


---

## 📖 About the Project

Rural schools across India struggle with infrastructure gaps — leaking roofs, broken desks, missing supplies. Government funding is slow, and damage compounds over time. Meanwhile, alumni who genuinely want to help have no reliable way to know what their school needs *right now*.

**Shaale-Vikas** solves this by acting as a transparency layer between schools and their alumni communities. Headmasters post specific "Micro-Needs" (e.g., *"Need 5 sets of paints for the wall"*), and alumni can pledge support — either by donating the items directly or contributing funds — turning the alumni network into an active support system.

---

## ✨ Features

| Feature | Description |
|---|---|
| 📋 **Needs Dashboard** | A live list of items/repairs needed, each with a cost estimate |
| 📊 **Progress Bar** | Real-time funding progress (e.g., *"60% of funds collected for Toilet Repair"*) |
| 🏆 **Donor Hall of Fame** | A public list celebrating everyone who has contributed |
| 📸 **Impact Photos** | Before-and-after photos documenting completed work |
| ✋ **Pledge Button** | Alumni can commit to fulfilling a need (simulated — no real money involved) |
| 🔧 **Admin Panel** | Headmaster can add, edit, and update needs and photos |

---

## 🛠️ Tech Stack

- **Language:** Kotlin
- **UI:** CardViews, Progress Bars, RecyclerView
- **Backend & Real-time Sync:** Firebase Realtime Database / Firestore
- **Media:** ImagePicker for uploading "Need" photos
- **Architecture:** MVVM (recommended)

---

## 🚀 Getting Started

### Prerequisites

- Android Studio (latest stable)
- JDK 11+
- A Firebase project (see setup below)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/ManishAditiya/Shaale-Vikas.git
   cd Shaale-Vikas
   ```

2. **Open in Android Studio**
   - File → Open → select the project folder

3. **Firebase Setup**
   - Create a project at [Firebase Console](https://console.firebase.google.com)
   - Add an Android app with your package name
   - Download `google-services.json` and place it in the `/app` directory
   - Enable **Realtime Database** (or Firestore) and **Storage**

4. **Build & Run**
   - Sync Gradle files
   - Run on an emulator or physical device (API 21+)

---

## 📁 Project Structure

```
Shaale-Vikas/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/         # Kotlin source files
│   │   │   ├── res/          # Layouts, drawables, strings
│   │   │   └── AndroidManifest.xml
│   └── build.gradle.kts
├── gradle/
├── build.gradle.kts
└── settings.gradle.kts
```

---

## 🎯 Impact Goals

- **Community Ownership** — Empowering citizens to take care of their local schools
- **Education Quality** — Ensuring infrastructure gaps don't affect learning outcomes
- **Transparency** — Building trust through before/after visual proof of completed work

---

## ✅ Success Criteria

- [ ] The Needs Dashboard is easily editable by the Admin (Headmaster)
- [ ] The Pledge button simulates commitment without involving real money
- [ ] The UI is professional, inspiring, and accessible

---

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -m 'Add your feature'`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Open a Pull Request




---

## 🙏 Acknowledgements

- Inspired by rural schools and the alumni communities who care about them
- Built as part of **Project Title 02 — Android App Development using GenAI**

---

