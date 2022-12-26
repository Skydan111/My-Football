import {useState, useEffect} from 'react';
import {getAllPlayers} from "./client";

import {
    Layout,
    Menu,
    Breadcrumb,
    Table, Empty
} from 'antd';

import {
    DesktopOutlined,
    PieChartOutlined,
    FileOutlined,
    TeamOutlined,
    UserOutlined,
} from '@ant-design/icons';

import './App.css';

const { Header, Content, Footer, Sider } = Layout;
const { SubMenu } = Menu;

const columns = [
    {
        title: 'FullName',
        dataIndex: 'fullName',
    },
    {
        title: 'Price',
        className: 'column-money',
        dataIndex: 'price',
        align: 'center',
    },
    {
        title: 'Amplua',
        dataIndex: 'amplua',
    },
];

function App() {
    const [footballPlayers, setFootballPlayers] = useState([]);
    const [collapsed, setCollapsed] = useState(false);

    const fetchPlayers = () =>
        getAllPlayers()
            .then(res => res.json())
            .then(data => {
                console.log(data);
                setFootballPlayers(data);
            })

    useEffect(() => {
        console.log("component is mounted");
        fetchPlayers();
    }, []);

    const renderFootballPlayers = () => {
        if (footballPlayers.length <= 0) {
            return <Empty/>;
        }
        return <Table
            dataSource = {footballPlayers}
            columns = {columns}
            bordered
            title={() => 'FootballPlayers'}
            rowKey={(footballPlayer) => JSON.stringify(footballPlayer)}
        />;
    }

    return <Layout style={{ minHeight: '100vh' }}>
        <Sider collapsible collapsed={collapsed}
               onCollapse={setCollapsed}>
            <div className="logo" />
            <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline">
                <Menu.Item key="1" icon={<PieChartOutlined />}>
                    Option 1
                </Menu.Item>
                <Menu.Item key="2" icon={<DesktopOutlined />}>
                    Option 2
                </Menu.Item>
                <SubMenu key="sub1" icon={<UserOutlined />} title="User">
                    <Menu.Item key="3">Oleg</Menu.Item>
                    <Menu.Item key="4">Nick</Menu.Item>
                    <Menu.Item key="5">Kate</Menu.Item>
                </SubMenu>
                <SubMenu key="sub2" icon={<TeamOutlined />} title="Team">
                    <Menu.Item key="6">Everton</Menu.Item>
                    <Menu.Item key="7">City</Menu.Item>
                    <Menu.Item key="8">Arsenal</Menu.Item>
                </SubMenu>
                <Menu.Item key="9" icon={<FileOutlined />}>
                    Files
                </Menu.Item>
            </Menu>
        </Sider>
        <Layout className="site-layout">
            <Header className="site-layout-background" style={{ padding: 0 }} />
            <Content style={{ margin: '0 16px' }}>
                <Breadcrumb style={{ margin: '16px 0' }}>
                    <Breadcrumb.Item>User</Breadcrumb.Item>
                    <Breadcrumb.Item>Bill</Breadcrumb.Item>
                </Breadcrumb>
                <div className="site-layout-background" style={{ padding: 24, minHeight: 360 }}>
                    {renderFootballPlayers()}
                </div>
            </Content>
            <Footer style={{ textAlign: 'center' }}>Fantasy Football by Oleg Skydan</Footer>
        </Layout>
    </Layout>
}

export default App;
