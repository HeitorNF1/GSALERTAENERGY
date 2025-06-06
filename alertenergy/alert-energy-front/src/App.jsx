import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import EnergyStatusChart from './Components/Graficos/EnergyStatusChart'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <EnergyStatusChart></EnergyStatusChart>
    </>
  )
}

export default App
