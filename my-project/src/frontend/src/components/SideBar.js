import {useState} from "react";
import {Menu} from "antd";
import {
    BarsOutlined,
    DollarCircleOutlined,
    TeamOutlined,
    TrophyOutlined,
    UserOutlined
} from "@ant-design/icons";
import {Link, Outlet} from "react-router-dom";
import SubMenu from "antd/es/menu/SubMenu";
import Sider from "antd/es/layout/Sider";

export default function SideBar() {
    const [collapsed, setCollapsed] = useState(false);

   return (<Sider collapsible collapsed={collapsed}
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
                <Link to="/myTeam"/>
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
           <Outlet/>
    </Sider>
   )
}