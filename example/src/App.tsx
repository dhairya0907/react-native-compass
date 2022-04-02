import React, { useEffect } from 'react'
import RNCompassModule, { Counter } from 'react-native-compass'

const App = () => {
  useEffect(() => {
    console.log(RNCompassModule)
  })

  return <Counter />
}

export default App
