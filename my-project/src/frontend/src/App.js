import {Route, Routes} from "react-router-dom";
import AllPlayers from "./components/pages/AllPlayers";
import TeamsByRate from "./components/pages/TeamsByRate";
import MyTeam from "./components/pages/MyTeam";

import {Layout} from 'antd';

import './App.css';
import HomePage from "./components/pages/HomePage";

export default function App() {

    return <Layout style={{minHeight: '100vh'}}>

        <Routes>
            <Route exact path="/" element={<HomePage/>}/>
            <Route exact path="/myTeam" element={<MyTeam/>}/>
            <Route exact path="/table" element={<TeamsByRate/>}/>
            <Route exact path="/transferMarket" element={<AllPlayers/>}/>
        </Routes>

    </Layout>
}
