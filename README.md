## 1. Project Title

"Shopme" - An E Commerce Electronics Store

## 2. Project Overview 

**Shopme** is a full-stack e-commerce web application developed using modern Java and Spring technologies. It offers a comprehensive online shopping experience for customers and robust administrative tools for managing the store. The project is adapted from the Udemy course: [Java Spring Boot E-Commerce Ultimate Course](https://www.udemy.com/course/spring-boot-e-commerce-ultimate/) by Nam Ha Minh.

## 3. User Roles & Features

### Administrator:

* **User Management:** Manage admin users.
* **Product Management:** Add/edit/delete products, categories, and brands.
* **Customer Management:** View and manage customer information.
* **Order Management:** Process and track orders.
* **Shipping & Payments:** Configure shipping options and payment methods.
* **Sales Reports:** Generate and view sales analytics.
* **Reviews & Questions:** Moderate product reviews and customer inquiries.
* **Settings:** Configure application settings.

### Customer:

* **Product Browsing:** View products by category and search functionality.
* **Product Details:** View detailed information about products.
* **Shopping Cart:** Add/remove products and view cart summary.
* **Checkout:** Secure checkout process with PayPal integration.
* **Order Tracking:** View order history and track current orders.
* **Account Management:** Register, login (including social login), and manage profile.

## 4. Tech Stack 

* **Backend:**

  * Java
  * Spring Boot
  * Spring Data JPA
  * Hibernate
  * Spring Security
  * Spring OAuth2 (Google & Facebook login)
  * Spring Mail
  * RESTful Web Services
  * JUnit, AssertJ, Mockito (Testing)

* **Frontend:**

  * Thymeleaf
  * Bootstrap 4
  * jQuery
  * HTML5

* **Database & Cloud:**

  * MySQL 8.0
  * Amazon S3 (for file storage)
  * Heroku (deployment)

* **Payments & Reporting:**

  * PayPal Checkout API
  * Google Chart API (for sales reports)
  
## 5. Installation 

i. Clone the git repo

```
https://github.com/AAdewunmi/Shopme-ECommerce-Application.git
```

ii. Open project folder

iii. Explore

😎


## 6. Getting Started

i. **Configure Database**

   * Create a MySQL database.
   * Update `application.properties` with your DB credentials.

3. **Build & Run**

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Access Application**

   * Admin Panel: `http://localhost:8080/ShopmeAdmin`
   * Customer Storefront: `http://localhost:80`

## 7. Deployment

This app is structured for deployment on:

* **Heroku** (Web)
* **Amazon S3** (Static file storage)

Be sure to configure environment variables for secure credentials.

## 8. Demo (UI Screenshots)

### - Customer Login

![Image](app_images/customer_login.png)

### - Customer Landing Page 

![Image](app_images/customer_landing_page.png)

### - Customer Shopping Cart

![Image](app_images/customer_shopping_cart.png)

### - Customer Check Out

![Image](app_images/customer_checkout.png)

### - Customer Manage Orders

![Image](app_images/customer_manage_orders.png)

### - Administrator Login 

![Image](app_images/admin_login.png)

### - Administrator Landing Page

![Image](app_images/admin_landing_page.png)

### - Administrator Manage Brands 

![Image](app_images/admin_manage_brands.png)

### - Administrator Manage Categories

![Image](app_images/admin_manage_categories.png)

### - Administrator Manage Customers

![Image](app_images/customers.png)

### - Administrator Manage Products

![Image](app_images/admin_manage_products.png)

### - Administrator Manage Users 

![Image](app_images/amin_manage_users.png)

### - Administrator Site Settings

![Image](app_images/admin_site_settings.png)

## 9. Contribution

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## 10. Adapted from 

UDEMY: Java Spring Boot E-Commerce Ultimate Course

Created by: Nam Ha Minh

Last updated 08/2024

URL: https://www.udemy.com/course/spring-boot-e-commerce-ultimate/
