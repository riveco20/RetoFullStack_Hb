function reducerElectrodomestico(state , action) {
    switch (action.type) {
        case 'update-item':
        const electrodomesticoUpItem = state.electrodomestico;
        const listUpdateEdit = electrodomesticoUpItem.listarElectrodomesticos.map((item)=>{
            if(item.id === action.item.id){
                 
            return action.item;

            }

            return item;
        });
        electrodomesticoUpItem.listarElectrodomesticos=listUpdateEdit;
        electrodomesticoUpItem.item={};
        return {...state, electrodomestico:electrodomesticoUpItem};
           
        case "delete-item":
      const electrodomesticoUpDelete = state.electrodomestico;
      const listUpdate = electrodomesticoUpDelete.listarElectrodomesticos.filter((item) => {
        return item.id !== action.id;
      });
      electrodomesticoUpDelete.listarElectrodomesticos = listUpdate;
      return { ...state, electrodomestico: electrodomesticoUpDelete };
    case "update-list":
      const electrodomesticoUpList = state.electrodomestico;
      electrodomesticoUpList.listarElectrodomesticos = action.listarElectrodomesticos;
      return { ...state, electrodomestico: electrodomesticoUpList };
    case "editi-item":
      const electrodomesticoUpEdit = state.electrodomestico;
      electrodomesticoUpEdit.item = action.item;
      return { ...state, electrodomestico: electrodomesticoUpEdit };
    case "add-item":
      const electrodomesticoUp = state.electrodomestico.listarElectrodomesticos;
      electrodomesticoUp.push(action.item);
      return { ...state, electrodomestico: { listarElectrodomesticos: electrodomesticoUp, item: {} } };
    default:
      return state;
  }
}

export default reducerElectrodomestico;



        