import React from "react";
import { StoreProvider } from "./store/Provider";
import Form from "./components/Form";
import List from "./components/List";
function App() {
  return (
    <StoreProvider>

      
      <div align = "center">
      <h2 align="center" >TIENDA ELECTRODOMESTICO</h2>
      <Form/>
      <List/>
      </div>
    </StoreProvider>
  );
}

export default App;