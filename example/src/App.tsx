import React, { useEffect } from 'react'
import {StyleSheet, View, Button} from 'react-native';
import { CompassModule, getDegree} from '@dhairyasharma/react-native-compass';

const App = () => {
  useEffect(() => {
  })

  return (
    <View style={styles.container}>
      <Button title="Get Degree" onPress={() => {
       getDegree().then(degree => {
          console.log(degree);
        });
        
      }} />
      <CompassModule style={styles.javaBtn} handHeight={280}/>
    </View>
  );
}
export default App

const styles = StyleSheet.create({
  container: {
   flex: 1,
    backgroundColor: 'pink',
    alignItems: 'center',
    justifyContent: 'center',
  },
  javaBtn: {
    width: "90%",
    height: "90%",

  },
});