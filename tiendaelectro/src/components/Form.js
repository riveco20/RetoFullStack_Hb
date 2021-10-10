import React, { useRef, useContext, useState } from "react";
import { Store } from "../store/Store";
const HOST_API = "http://localhost:8080/api";

const Form = () => {
  const formRef = useRef(null);
  const {
    dispatch,
    state: {electrodomestico},
  } = useContext(Store);
  const item = electrodomestico.item;
  const [state, setState] = useState(item);

  const onAdd = (event) => {
    event.preventDefault();

    const request = {
        nameElectrodomestico: state.nameElectrodomestico,
      id: null,
      vendido: false,
    };

    fetch(HOST_API + "/electrodomestico", {
      method: "POST",
      body: JSON.stringify(request),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((electrodomestico) => {
        dispatch({ type: "add-item", item: electrodomestico });
        setState({ nameElectrodomestico: "" });
        formRef.current.reset();
      });
  };

  const onEdit = (event) => {
    event.preventDefault();

    const request = {
    nameElectrodomestico: state.nameElectrodomestico,
      id: item.id,
      isVendido: item.isVendido,
    };

    fetch(HOST_API + "/actualizarElectrodomestico", {
      method: "PUT",
      body: JSON.stringify(request),
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((electrodomestico) => {
        dispatch({ type: "update-item", item: electrodomestico });
        setState({ nameElectrodomestico: "" });
        formRef.current.reset();
      });
  };

  return (
    <form ref={formRef}>
      <input
        type="text"
        nameElectrodomestico="nameElectrodomestico"
        placeholder="¿Que vas agregar?"
        defaultValue={item.nameElectrodomestico}
        onChange={(event) => {
          setState({ ...state, nameElectrodomestico: event.target.value });
        }}
      ></input>
      {item.id && <button onClick={onEdit}>Actualizar</button>}
      {!item.id && <button onClick={onAdd}>Crear</button>}
    </form>
  );
};
export default Form;