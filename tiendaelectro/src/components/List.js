import React, { useContext, useEffect } from "react";
import { Store } from "../store/Store";

const HOST_API = "http://localhost:8080/api";
const List = () => {
  const {
    dispatch,
    state: {electrodomestico},
  } = useContext(Store);
  const currentList = electrodomestico.listarElectrodomesticos;

  useEffect(() => {
    fetch(HOST_API + "/electrodomestico")
      .then((response) => response.json())
      .then((listarElectrodomesticos) => {
        dispatch({ type: "update-list", listarElectrodomesticos });
      });
  }, [dispatch]);

  const onDelete = (id) => {
    fetch(HOST_API + "/" + id + "/electrodomestico", {
      method: "DELETE",
    }).then((listarElectrodomesticos) => {
      dispatch({ type: "delete-item", id });
    });
  };

  const onEdit = (id) => {
    dispatch({ type: "editi-item", item:id });
    
  };

  const onChange = (event, electrodomestico) => {
    const request = {
      nameElectrodomestico: electrodomestico.nameElectrodomestico,
      id: electrodomestico.id,
      vendido: event.target.checked,
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
      });
  };

  const decorationDone = {
    textDecoration: "line-through",
  };
  return (
    <div>
      <table>
        <thead>
          <tr>
            <td>ID</td>
            <td>electrodomestico</td>
            <td>Marca</td>
            <td>Precio</td>
            <td>Serial</td>
            <td>¿vendido?</td>
          </tr>
        </thead>
        <tbody>
          {currentList.map((electrodomestico) => {
            return (
              <tr key={electrodomestico.id} style={electrodomestico.vendido? decorationDone : {}}>
                <td>{electrodomestico.id}</td>
                <td>{electrodomestico.nameElectrodomestico}</td>
                <td>{electrodomestico.marca}</td>
                <td>{electrodomestico.precio}</td>
                <td>{electrodomestico.serial}</td>
                <td>
              
                  <input type="checkbox"
                    defaultChecked={electrodomestico.vendido}
                    onChange={(event) => onChange(event, electrodomestico)}
                  ></input>
                </td>
                <td>
                  <button onClick={() => onDelete(electrodomestico.id)}>Eliminar</button>
                </td>
                <td>
                  <button onClick={() => onEdit(electrodomestico)}>Editar</button>
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default List;