import * as actionType from './actionTypes';

export const buyProduct = (product) => {
    return {
        type: actionType.BUY_PRODUCT,
        payload: product,
    };
};

export const deleteProduct = (product) => {
    return {
        type: actionType.BUY_PRODUCT,
        payload: product,
    };
};