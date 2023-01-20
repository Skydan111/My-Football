import {Route, Routes} from "react-router-dom";
import MyTeam from "./pages/MyTeam";
import TeamsByRate from "./pages/TeamsByRate";
import AllPlayers from "./pages/AllPlayers";
import {Layout} from "antd";
import SideBar from "./SideBar";

export default function GameRoutes() {
    return (
        <Layout style={{minHeight: '100vh'}}>

            <SideBar/>

            <Routes>
                <Route exact path="/" element={<MyTeam/>}/>
                <Route exact path="/table" element={<TeamsByRate/>}/>
                <Route exact path="/transferMarket" element={<AllPlayers/>}/>
            </Routes>

        </Layout>
    )
}