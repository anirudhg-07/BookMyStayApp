# Hotel Booking System (Java)

## Overview

This project is a modular Java-based Hotel Booking System demonstrating core software engineering concepts including object-oriented design, validation, exception handling, concurrency, cancellation handling, and data persistence.

It is structured as multiple use cases to showcase real-world system behaviors step by step.

---

## Features

* Booking history management
* Report generation
* Input validation with custom exceptions
* Booking cancellation with rollback tracking
* Concurrent booking simulation using threads
* File-based data persistence and recovery

---

## Project Structure

Each use case is implemented as a standalone main class:

* UseCaseBookingHistoryReport → Booking history & reporting
* UseCaseErrorHandlingValidation → Input validation & error handling
* UseCase10BookingCancellation → Booking cancellation & rollback
* UseCase11ConcurrentBookingSimulation → Multithreading & synchronization
* UseCase12DataPersistenceRecovery → File persistence & system recovery

---

## Technologies Used

* Java (Core)
* Collections Framework
* File I/O
* Multithreading

---

## How to Run

### 1. Compile

```bash
javac UseCaseBookingHistoryReport.java
javac UseCaseErrorHandlingValidation.java
javac UseCase10BookingCancellation.java
javac UseCase11ConcurrentBookingSimulation.java
javac UseCase12DataPersistenceRecovery.java
```

### 2. Run

```bash
java UseCaseBookingHistoryReport
java UseCaseErrorHandlingValidation
java UseCase10BookingCancellation
java UseCase11ConcurrentBookingSimulation
java UseCase12DataPersistenceRecovery
```

---

## Sample Outputs

### Booking Report

```
Booking History Report
Guest: Abhi, Room Type: Single
Guest: Sudha, Room Type: Double
Guest: Vamsi, Room Type: Suite
```

### Validation Error

```
Booking Validation
Booking failed: Invalid room type selected.
```

### Cancellation

```
Booking cancelled successfully. Inventory restored for room type: Single
```

### System Recovery

```
System Recovery
No valid inventory data found. Starting fresh.
```

---

## Concepts Demonstrated

* Object-Oriented Programming (Encapsulation, Abstraction)
* Exception Handling (Custom Exceptions)
* Synchronization & Thread Safety
* Data Structures (List, Map, Queue, Stack)
* File Persistence (Read/Write)
* Clean Modular Design

---

## Author

Your Name

---

## License

This project is open source and available under the MIT License.
