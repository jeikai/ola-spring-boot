export const API_BASE_URL = 'https://localhost:8080/api/v1';

export const API_ENDPOINTS = {
    AUTH : {
        LOGIN: '/auth/login',
        REGISTER: '/auth/register',
    },
    CUSTOMERS: {
        BASE: '/customers',
        DETAILS: (customerId) => `/customers/${customerId}`,
        ORDERS: (customerId) => `/customers/${customerId}/orders`, 
    },
    PRODUCTS: {
        BASE: '/products',
        DETAILS: (productId) => `/products/${productId}`,
        SEARCH: '/products/search',
    }
};

export const ROLES = {
    ADMIN: 'ADMIN',
    CUSTOMER: 'USER'
}

export const KEY_STORAGE = {
    ACCESS_TOKEN: "accessToken",
    REFRESH_TOKEN: "refreshToken",
    USER_DATA: "userData"
}

export const ERROR_MESSAGES = {
    NETWORK_ERROR: "Network error. Please try again later.",
    UNAUTHORIZED: "You are not authorized to perform this action.",
    NOT_FOUND: "The requested resource was not found.",
    SERVER_ERROR: "An unexpected server error occurred. Please try again later.",
    PRODUCT_EMPTY: "No products available at the moment."
}

export const SUCCESS_MESSAGES = {
    LOGIN_SUCCESS: "Login successful. Welcome back!",
    REGISTER_SUCCESS: "Registration successful. You can now log in.",
    ORDER_PLACED: "Your order has been placed successfully.",
    PROFILE_UPDATED: "Your profile has been updated successfully."
}