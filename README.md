# 🎬 Streamflix - Movie Streaming Backend  

## 📌 Overview  
Streamflix is a **movie streaming backend** built with **Spring Boot**. It provides user authentication, movie management, watchlists, reviews, and secure payment processing for a seamless streaming experience.  

---

## 🚀 Features  
✅ User authentication & JWT-based authorization  
✅ Admin panel for managing users & movies  
✅ CRUD operations for movies & watchlists  
✅ User-generated reviews & ratings  
✅ Secure payment processing  
✅ RESTful API with Spring Boot  

---

## 🛠️ Tech Stack  
- **Backend**: Spring Boot, Spring Security, JWT  
- **Database**: PostgreSQL / MySQL  
- **ORM**: Hibernate / JPA  
- **Authentication**: JWT  
- **Build Tool**: Maven  
- **Containerization**: Docker (optional)  
- **Version Control**: Git & GitHub  

---

## 📂 Project Structure  

movie-streaming-backend/
│── src/main/java/com/streamflix
│   ├── controllers/
│   │   ├── UserController.java
│   │   ├── MovieController.java
│   │   ├── WatchlistController.java
│   │   ├── ReviewController.java
│   │   ├── PaymentController.java
│   │   ├── AdminController.java
│   ├── services/
│   │   ├── UserService.java
│   │   ├── MovieService.java
│   │   ├── WatchlistService.java
│   │   ├── ReviewService.java
│   │   ├── PaymentService.java
│   ├── repositories/
│   │   ├── UserRepository.java
│   │   ├── MovieRepository.java
│   │   ├── WatchlistRepository.java
│   │   ├── ReviewRepository.java
│   │   ├── PaymentRepository.java
│   ├── models/
│   │   ├── entities/
│   │   │   ├── User.java
│   │   │   ├── Movie.java
│   │   │   ├── Watchlist.java
│   │   │   ├── Review.java
│   │   │   ├── Payment.java
│   │   ├── dtos/
│   │   │   ├── UserDto.java
│   │   │   ├── MovieDto.java
│   │   │   ├── WatchlistDto.java
│   │   │   ├── ReviewDto.java
│   │   │   ├── PaymentDto.java
│   ├── mappers/
│   │   ├── UserMapper.java
│   │   ├── MovieMapper.java
│   │   ├── WatchlistMapper.java
│   │   ├── ReviewMapper.java
│   │   ├── PaymentMapper.java
│   ├── security/
│   │   ├── JwtTokenProvider.java
│   │   ├── JwtAuthFilter.java
│   │   ├── SecurityConfig.java
│   ├── exceptions/
│   │   ├── ResourceNotFoundException.java
│   │   ├── CustomExceptionHandler.java
│   ├── config/
│   │   ├── AppConfig.java
│   ├── MovieStreamingApplication.java


📝 API Endpoints
🔐 Authentication
POST /api/user/register – Register a new user
POST /api/user/login – Login & receive JWT
🎬 Movies
POST /api/movies – Add a movie
GET /api/movies/{id} – Get movie details
GET /api/movies – Get all movies
PUT /api/movies/{id} – Update a movie
DELETE /api/movies/{id} – Delete a movie
📃 Watchlist
POST /api/watchlist – Add movie to watchlist
GET /api/watchlist/{userId} – Get user’s watchlist
⭐ Reviews
POST /api/reviews – Add a review
GET /api/reviews/{movieId} – Get reviews for a movie
💳 Payments
POST /api/payments – Process a payment
GET /api/payments/{userId} – Get user’s payment history
