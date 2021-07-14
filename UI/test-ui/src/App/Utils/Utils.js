const Utils = {
    getFromLocalStorage: (key) => {
        let value = "";
        try {
            value = localStorage.getItem(key);
        }
        catch (error) {
            value = "";
        }
        return value;
    },
    setToLocalStorage: (key, value) => {
        try {
            localStorage.setItem(key, value);
        }
        catch (error) {
            throw error;
        }
    },
};

export default Utils;