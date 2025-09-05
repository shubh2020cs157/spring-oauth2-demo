# 🔐 Spring OAuth2 Multi-Provider Authentication System

A comprehensive **Spring Boot 3.x** application demonstrating modern authentication patterns with **OAuth2** integration across multiple providers. This project showcases enterprise-grade security implementation with both traditional form login and OAuth2 social login capabilities.

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://openjdk.java.net/)

## ✨ Features

### 🔐 Authentication Methods

- ✅ **Form-based Authentication** (Username/Password)
- ✅ **Google OAuth2** Integration
- ✅ **GitHub OAuth2** Integration
- ✅ **LinkedIn OAuth2** Integration
- ✅ **Microsoft OAuth2** Integration

### 🎨 User Experience

- 🎯 **Professional UI** with Modern Design
- 🎨 **Responsive Layout** with Gradient Backgrounds
- 🎭 **FontAwesome Icons** for Provider Branding
- 📱 **Mobile-Friendly** Interface
- ⚡ **Smooth Animations** and Transitions

### 🔒 Security Features

- 🛡️ **CSRF Protection** on all forms
- 🔐 **Session Management** with proper invalidation
- 🚪 **Secure Logout** with POST method
- 👤 **Role-based Access Control** setup
- 🔑 **Spring Security 6.x** latest version

### 📊 User Information Display

- 👤 **User Profile Information**
- 🔍 **Authentication Method Detection**
- 📋 **Detailed Attributes Display**
- 🎯 **Provider-specific Data Handling**

## 🏗️ Architecture Overview

```
┌─────────────────┐    ┌──────────────────┐    ┌─────────────────┐
│   Frontend      │    │   Spring MVC     │    │   Database      │
│   (Thymeleaf)   │◄──►│   Controllers    │◄──►│   (In-Memory)   │
│                 │    │                  │    │                 │
│ • Login Forms   │    │ • AuthController │    │ • User Store    │
│ • User Dashboard│    │ • SecurityConfig │    │ • Sessions      │
└─────────────────┘    └──────────────────┘    └─────────────────┘
         │                       │                       │
         └───────────────────────┼───────────────────────┘
                                 │
                    ┌────────────────────┐
                    │  Spring Security   │
                    │                    │
                    │ • OAuth2 Clients   │
                    │ • Form Login       │
                    │ • CSRF Protection  │
                    │ • Session Mgmt     │
                    └────────────────────┘
```

## 📚 Learning Outcomes

This project demonstrates advanced concepts in:

### 🔐 Security & Authentication

- **OAuth2 Protocol** implementation
- **Spring Security** configuration patterns
- **CSRF Protection** mechanisms
- **Session Management** best practices

### 🚀 Spring Boot Ecosystem

- **Spring Boot 3.x** with Jakarta EE
- **Spring Security 6.x** integration
- **Thymeleaf** templating engine
- **Maven** build management
- **Dependency Injection** patterns

### 🎨 Frontend Integration

- **Responsive HTML/CSS** design
- **FontAwesome** icon integration
- **Thymeleaf** expressions and conditionals
- **Form handling** with validation

### 🛠️ Development Skills

- **Multi-provider OAuth2** setup
- **Error handling** and debugging
- **Configuration management**
- **RESTful API** development

## 🚀 Quick Start

### Prerequisites

- ☕ **Java 17** or higher
- 🏗️ **Maven 3.6+**
- 🌐 **Internet connection** for OAuth2 providers

### Demo Mode (No Setup Required)

```bash
# Clone the repository
git clone https://github.com/your-username/spring-oauth2-demo.git
cd spring-oauth2-demo

# Run the application
./mvnw spring-boot:run
```

**Demo Credentials:**

- Username: `user`
- Password: `password`

### Production Setup with OAuth2

#### 1. Google OAuth2 Setup

1. Visit [Google Cloud Console](https://console.cloud.google.com/)
2. Create/select a project
3. Enable **Google Identity API**
4. Navigate to **APIs & Services** → **Credentials**
5. Create **OAuth 2.0 Client ID**
6. Add redirect URI: `http://localhost:8080/login/oauth2/code/google`

#### 2. GitHub OAuth2 Setup

1. Go to [GitHub Developer Settings](https://github.com/settings/developers)
2. Click **"New OAuth App"**
3. Set **Authorization callback URL**: `http://localhost:8080/login/oauth2/code/github`
4. Note down **Client ID** and **Client Secret**

#### 3. LinkedIn OAuth2 Setup

1. Visit [LinkedIn Developers](https://developer.linkedin.com/)
2. Create a new application
3. Configure **OAuth 2.0 settings**
4. Add redirect URL: `http://localhost:8080/login/oauth2/code/linkedin`

#### 4. Microsoft OAuth2 Setup

1. Go to [Azure Portal](https://portal.azure.com/)
2. Navigate to **Azure Active Directory** → **App registrations**
3. Create new registration
4. Add redirect URI: `http://localhost:8080/login/oauth2/code/microsoft`

### Configuration

Update `src/main/resources/application.properties`:

```properties
# Default User Credentials (Form Login)
spring.security.user.name=user
spring.security.user.password=password
spring.security.user.roles=USER

# OAuth2 Client Configurations
spring.security.oauth2.client.registration.google.client-id=your-google-client-id
spring.security.oauth2.client.registration.google.client-secret=your-google-client-secret

spring.security.oauth2.client.registration.github.client-id=your-github-client-id
spring.security.oauth2.client.registration.github.client-secret=your-github-client-secret

# Add similar configurations for LinkedIn and Microsoft
```

## 🎮 Usage Guide

### Starting the Application

```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

### Authentication Flow

1. **Access Application**: Navigate to `http://localhost:8080`
2. **Choose Login Method**:
   - **Form Login**: Use demo credentials (user/password)
   - **OAuth2 Login**: Click any provider button
3. **Authentication**: Complete OAuth2 flow or form submission
4. **Dashboard**: View user information and authentication details

### Demo Screenshots

#### Login Page

```
┌─────────────────────────────────────────────────────────┐
│                 Welcome to Multi-Provider Auth          │
│                                                         │
│  ┌─────────────────────────────────────────────────┐     │
│  │ Username: [user]                               │     │
│  │ Password: [••••••]                              │     │
│  │ [Sign In]                                       │     │
│  └─────────────────────────────────────────────────┘     │
│                                                         │
│                    or continue with                     │
│                                                         │
│  ┌─────────────┐ ┌─────────────┐ ┌─────────────┐        │
│  │ 🔵 Google   │ │ ⚫ GitHub   │ │ 🔗 LinkedIn │        │
│  └─────────────┘ └─────────────┘ └─────────────┘        │
│                                                         │
│  ┌─────────────┐                                        │
│  │ 🔷 Microsoft│                                        │
│  └─────────────┘                                        │
└─────────────────────────────────────────────────────────┘
```

#### User Dashboard

```
┌─────────────────────────────────────────────────────────┐
│              Welcome to Your Dashboard!                 │
│                                                         │
│ 👤 User Information:                                    │
│ • Name: John Doe                                        │
│ • Email: john@example.com                               │
│ • Login Method: OAuth2 Provider                         │
│                                                         │
│ 📊 OAuth2 Attributes:                                   │
│ • sub: 123456789                                        │
│ • email_verified: true                                  │
│ • name: John Doe                                        │
│                                                         │
│                    [Logout]                              │
└─────────────────────────────────────────────────────────┘
```

## 📁 Project Structure

```
spring-oauth2-demo/
├── src/main/java/com/shubh/SpringOAuth2/
│   ├── SpringOAuth2Application.java      # Main application class
│   ├── AuthController.java               # Authentication controller
│   └── SecurityConfig.java               # Security configuration
├── src/main/resources/
│   ├── application.properties            # Application configuration
│   └── templates/
│       ├── login.html                    # Login page template
│       └── home.html                     # Dashboard template
├── pom.xml                               # Maven configuration
└── README.md                            # Project documentation
```

## 🔌 API Endpoints

| Endpoint                  | Method | Description           | Authentication |
| ------------------------- | ------ | --------------------- | -------------- |
| `/`                       | GET    | Redirects to login    | Public         |
| `/login`                  | GET    | Login page            | Public         |
| `/perform_login`          | POST   | Form login processing | Public         |
| `/home`                   | GET    | User dashboard        | Private        |
| `/perform_logout`         | POST   | Logout processing     | Private        |
| `/oauth2/authorization/*` | GET    | OAuth2 authorization  | Public         |

## 🛠️ Technologies & Dependencies

| Technology               | Version | Purpose                        |
| ------------------------ | ------- | ------------------------------ |
| **Spring Boot**          | 3.5.5   | Application framework          |
| **Spring Security**      | 6.5.3   | Authentication & authorization |
| **Spring OAuth2 Client** | 6.5.3   | OAuth2 integration             |
| **Thymeleaf**            | 3.1.3   | Template engine                |
| **FontAwesome**          | 6.0.0   | UI icons                       |
| **Java**                 | 17      | Programming language           |
| **Maven**                | 3.9+    | Build tool                     |

## 🔧 Configuration Details

### Security Configuration Features

- ✅ **Multi-provider OAuth2** support
- ✅ **Form-based authentication** fallback
- ✅ **CSRF protection** on all forms
- ✅ **Session management** with invalidation
- ✅ **Role-based access control**
- ✅ **Custom login/logout URLs**

### OAuth2 Provider Support

| Provider  | Status   | Configuration Required  |
| --------- | -------- | ----------------------- |
| Google    | ✅ Ready | Client ID/Secret needed |
| GitHub    | ✅ Ready | Client ID/Secret needed |
| LinkedIn  | ✅ Ready | Client ID/Secret needed |
| Microsoft | ✅ Ready | Client ID/Secret needed |

## 🐛 Troubleshooting

### Common Issues

#### 1. OAuth2 Connection Failed

```
Error: Invalid client credentials
```

**Solution**: Ensure OAuth2 client credentials are correctly configured in `application.properties`

#### 2. CSRF Token Errors

```
Error: Invalid CSRF token
```

**Solution**: CSRF tokens are automatically handled. Try refreshing the page.

#### 3. Template Errors

```
Error: Template processing failed
```

**Solution**: Ensure all Thymeleaf expressions are properly formatted.

#### 4. Port Already in Use

```
Error: Port 8080 is already in use
```

**Solution**: Change port in `application.properties`:

```properties
server.port=8081
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is currently unlicensed. You can add a license by creating a `LICENSE` file in the root directory with your preferred license terms.

## 🙏 Acknowledgments

- Spring Boot team for excellent documentation
- OAuth2 providers for their APIs
- Open source community for inspiration

## 📞 Support

If you have any questions or issues:

- Create an [issue](https://github.com/your-username/spring-oauth2-demo/issues)
- Check the [troubleshooting](#-troubleshooting) section
- Review the [setup instructions](#-quick-start)

---

## 🚀 GitHub Upload Instructions

### Step 1: Initialize Git Repository

```bash
# Initialize git in your project directory
git init
git add .
git commit -m "feat: Add comprehensive OAuth2 multi-provider authentication system

- Implement Spring Security 6.x with OAuth2 client
- Add support for Google, GitHub, LinkedIn, Microsoft OAuth2
- Create professional UI with Thymeleaf templates
- Add CSRF protection and secure session management
- Include form-based authentication as fallback
- Add comprehensive documentation and setup guide"
```

### Step 2: Create GitHub Repository

1. Go to [GitHub.com](https://github.com)
2. Click **"New repository"**
3. Name it: `spring-oauth2-demo` or `multi-provider-auth-spring`
4. Add description: _"Spring Boot OAuth2 Multi-Provider Authentication with Professional UI"_
5. Choose **Public** repository
6. **DO NOT** initialize with README (we already have one)

### Step 3: Push to GitHub

```bash
# Add your GitHub repository as remote
git remote add origin https://github.com/your-username/your-repo-name.git

# Push to GitHub
git branch -M main
git push -u origin main
```

### Step 4: Add Repository Topics

After uploading, add these topics to your repository:

- `spring-boot`
- `spring-security`
- `oauth2`
- `authentication`
- `java`
- `thymeleaf`
- `maven`
- `web-development`

### Step 5: Create Release (Optional)

```bash
# Create a git tag
git tag -a v1.0.0 -m "Initial release with OAuth2 multi-provider authentication"

# Push the tag
git push origin v1.0.0
```

---

⭐ **Star this repository** if you found it helpful!

**Happy coding!** 🚀✨

---

_Built with ❤️ using Spring Boot 3.x and modern web technologies_
