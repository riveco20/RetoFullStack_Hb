import React from "react";
import { StoreProvider } from "./store/Provider";
import Form from "./components/Form";
import List from "./components/List";
function App() {
  return (
    <StoreProvider>
       
      <h2 align="center" class="mb-4">TIENDA ELECTRODOMESTICO</h2>
      <Form/>
      <List/>
    </StoreProvider>
  );
}

export default App;