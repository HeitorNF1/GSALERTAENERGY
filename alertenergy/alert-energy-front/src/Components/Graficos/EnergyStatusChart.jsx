import React, { useEffect, useState } from 'react';
import { PieChart, Pie, Cell, Tooltip, ResponsiveContainer } from 'recharts';

export default function EnergyStatusChart() {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:8080/alerts');
        if (!response.ok) {
          throw new Error(`Erro HTTP! Status: ${response.status}`);
        }
        const json = await response.json();
        setData(json);
      } catch (error) {
        console.error('Erro ao buscar dados:', error);
      } finally {
        setLoading(false);
      }
    };

    fetchData();
  }, []);

  if (loading) {
    return <p>Carregando dados...</p>;
  }

  const comEnergiaCount = data.filter((item) => item.comEnergia).length;
  const semEnergiaCount = data.length - comEnergiaCount;

  const chartData = [
    { name: 'Com Energia', value: comEnergiaCount },
    { name: 'Sem Energia', value: semEnergiaCount },
  ];

  const COLORS = ['#00C49F', '#FF8042'];

  return (
    <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
      <h2>Status da Energia por Local</h2>

      {/* Cards com Totais */}
      <div style={{ display: 'flex', gap: '2rem', marginBottom: '2rem',color:'#000000' }}>
        <div style={{ backgroundColor: '#e0fff7', padding: '1rem 2rem', borderRadius: '8px' }}>
          <h3>Com Energia</h3>
          <p style={{ fontSize: '1.5rem', fontWeight: 'bold' }}>{comEnergiaCount}</p>
        </div>
        <div style={{ backgroundColor: '#ffe0d5', padding: '1rem 2rem', borderRadius: '8px' }}>
          <h3>Sem Energia</h3>
          <p style={{ fontSize: '1.5rem', fontWeight: 'bold',color:'#000000' }}>{semEnergiaCount}</p>
        </div>
      </div>

      {/* Gráfico de Rosquinha */}
      <ResponsiveContainer width="50%" height={300}>
        <PieChart>
          <Pie
            data={chartData}
            dataKey="value"
            nameKey="name"
            cx="50%"
            cy="50%"
            innerRadius={60}
            outerRadius={100}
            fill="#8884d8"
            label
          >
            {chartData.map((entry, index) => (
              <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />
            ))}
          </Pie>
          <Tooltip />
        </PieChart>
      </ResponsiveContainer>
    </div>
  );
}
