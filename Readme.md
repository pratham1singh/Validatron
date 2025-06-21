# ✅ Validatron - Advanced Validation Toolkit for Spring Boot

[![Java](https://img.shields.io/badge/Java-17+-blue.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/github/license/yourusername/validatron.svg)](LICENSE)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-green.svg)](CONTRIBUTING.md)

---

**Validatron** is a modular and extensible validation library for Spring Boot that goes beyond the default Bean Validation (`javax.validation`) constraints. It provides unique field-level and class-level annotations tailored for real-world enterprise applications—like unique DB fields, Aadhaar validation, input sanitization, password strength checks, and more.

---

## 🚀 Features

- ✅ Plug-and-play custom validators
- 🔒 Security-focused: includes XSS/SQL injection validation
- 📆 Rich date and time checks (weekend-only, working hours, etc.)
- 🆔 Country-specific ID validation (PAN, Aadhaar, GST)
- 🔁 Cross-field logic (`@FieldsMatch`, `@ConditionalRequired`)
- ⚙️ Simple annotation-driven usage
- 🧪 Fully testable with built-in test support

---

## 📦 Installation

> _Coming soon as a Maven package._ For now, clone and import as a module:

```bash
git clone https://github.com/pratham1singh/Validatron.git
