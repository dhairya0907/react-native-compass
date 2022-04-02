import React, { useEffect } from "react";
import { StyleSheet, View, Text, TouchableOpacity } from "react-native";
import { CompassModule, getDegree } from "@dhairyasharma/react-native-compass";

const App = () => {
  const [degree, setDegree] = React.useState("");

  useEffect(() => {});

  return (
    <View style={styles.container}>
      <TouchableOpacity
        style={styles.degreeButton}
        onPress={() => {
          getDegree().then((degree) => {
            setDegree(`Degree : ${degree}`);
          });
        }}
      >
        <Text style={{ color: "#000" }}>Get Degree</Text>
      </TouchableOpacity>
      <Text
        style={{
          color: "#fff",
          bottom: 150,
          position: "absolute",
          fontSize: 20,
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        {degree}
      </Text>
      <CompassModule style={styles.compassModule} handHeight={270} />
    </View>
  );
};
export default App;

const styles = StyleSheet.create({
  container: {
    width: "100%",
    height: "100%",
    backgroundColor: "#000",
    alignItems: "center",
  },
  compassModule: {
    width: "100%",
    height: "100%",
    top: 10,
  },
  degreeButton: {
    width: 200,
    height: 70,
    bottom: 10,
    position: "absolute",
    backgroundColor: "#87CEEB",
    justifyContent: "center",
    alignItems: "center",
    zIndex: 1,
  },
});
