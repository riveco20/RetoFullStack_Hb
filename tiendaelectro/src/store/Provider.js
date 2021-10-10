import React, { useReducer } from "react";
import { initial } from "./Store";
import reducerElectrodomestico from "./Reduce";
import { Store } from "./Store";

export const StoreProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducerElectrodomestico, initial);

  return (
    <Store.Provider value={{ state, dispatch }}>{children}</Store.Provider>
  );
};