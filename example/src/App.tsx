import React, { useEffect } from 'react'
import RNCompassModule, { Counter } from '@dhairyasharma/react-native-compass'

const App = () => {
  useEffect(() => {
    console.log(RNCompassModule)
  })

  return <Counter />
}

export default App
