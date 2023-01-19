import {useState} from 'react';
import {Route, Link, Routes} from "react-router-dom";
import AllPlayers from "./components/pages/AllPlayers";
import TeamsByRate from "./components/pages/TeamsByRate";
import MyTeam from "./components/pages/MyTeam";

import {
    Layout,
    Menu,
} from 'antd';

import './App.css';
import {
    BarsOutlined,
    DollarCircleOutlined,
    TeamOutlined,
    TrophyOutlined,
    UserOutlined
} from "@ant-design/icons";
import SubMenu from "antd/es/menu/SubMenu";

const {Header, Content, Sider, Footer} = Layout;

export default function App() {

    const [collapsed, setCollapsed] = useState(false);


    return <Layout style={{minHeight: '100vh'}}>

        <Sider collapsible collapsed={collapsed}
               onCollapse={setCollapsed}>
            <div className="logo"/>
            <Menu
                theme="dark"
                defaultSelectedKeys={["myTeam"]}
                mode="inline"
            >
                <Menu.Item
                    key={"myTeam"}
                    icon={<TrophyOutlined/>}
                >
                    My Team
                    <Link to="/"/>
                </Menu.Item>

                <Menu.Item
                    key={"table"}
                    icon={<BarsOutlined/>}
                >
                    Table
                    <Link to="/table"/>
                </Menu.Item>

                <SubMenu key="users" icon={<UserOutlined/>} title="Users">
                    <Menu.Item>Oleg</Menu.Item>
                    <Menu.Item>Nick</Menu.Item>
                    <Menu.Item>Kate</Menu.Item>
                </SubMenu>
                <SubMenu key="teams" icon={<TeamOutlined/>} title="Teams">
                    <Menu.Item>Everton</Menu.Item>
                    <Menu.Item>City</Menu.Item>
                    <Menu.Item>Arsenal</Menu.Item>
                </SubMenu>
                <Menu.Item
                    key={"transferMarket"}
                    icon={<DollarCircleOutlined/>}
                >
                    Transfer Market
                    <Link to="/transferMarket"/>
                </Menu.Item>
            </Menu>
        </Sider>

        <Layout className="site-layout">
            <Header className="site-layout-background">
                <h2>My Fantasy League</h2>
            </Header>
            <Content>
                <Routes>
                    <Route exact path="/" element={<MyTeam/>}/>
                    <Route path="/table" element={<TeamsByRate/>}/>
                    <Route exact path="/transferMarket" element={<AllPlayers/>}/>
                </Routes>
            </Content>
            <Footer className="site-layout-footer">Fantasy League by Oleg Skydan</Footer>
        </Layout>

    </Layout>
}
