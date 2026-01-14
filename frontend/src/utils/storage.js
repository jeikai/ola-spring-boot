export const localStorage = {
    setItem: (key, value) => {
        window.localStorage.setItem(key, JSON.stringify(value));
    },
    getItem: (key) => {
        const item = window.localStorage.getItem(key);
        return item ? JSON.parse(item) : null;
    },
    removeItem: (key) => {
        window.localStorage.removeItem(key);
    }
};

export const sessionStorage = {
    setItem: (key, value) => {
        window.sessionStorage.setItem(key, JSON.stringify(value));
    },
    getItem: (key) => {
        const item = window.sessionStorage.getItem(key);   
        return item ? JSON.parse(item) : null;
    },
    removeItem: (key) => {
        window.sessionStorage.removeItem(key);
    }
};

export const authStorage = {
    saveToken : (token) => {
        localStorage.setItem('authToken', token);
    },

    saveUserData : (userData) => {
        sessionStorage.setItem('userData', userData);
    }
}