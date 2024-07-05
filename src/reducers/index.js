import { act } from 'react';
import * as actionType from './actionTypes';

const initialState = {
    cartArr: [],
};

const cartReducer = (state = initialState, action) => {
    switch (action.type) {
        case actionType.BUY_PRODUCT:
            const productInCart = state.cartArr.find(
                (p) => p.id == action.payload.id
            );
            if (!productInCart) {
                return {
                    cartArr: [...state.cartArr, action.payload]
                }
            } else {
                let newCart = state.cartArr;
                const objIndex = newCart.findIndex(
                    (obj) => obj.id == action.payload.id
                );
                //Tang so luong neu trung
                newCart[objIndex].quantity = newCart[objIndex].quantity + 1;
                return { cartArr: [...newCart] };
            }
        case actionType.DELETE_PRODUCT:
            let newCart = state.cartArr;
            const objIndex = newCart.findIndex((obj) => obj.id == action.payload.id);
            newCart.splice(objIndex, 1);
            return { cartArr: [...newCart] };
        default:
            break;
    }
};

export default cartReducer;