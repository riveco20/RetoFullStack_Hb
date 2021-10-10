import {createContext} from "react"
export const initial= {
    electrodomestico: {listarElectrodomesticos:[], item:{}},

};

export const Store = createContext(initial);