import {useState, useEffect} from 'react';
import {getAllPlayers} from "../../client";
import {
    Empty,
    Layout,
    Table
} from "antd";
import {Content, Footer, Header} from "antd/es/layout/layout";
import SideBar from "../SideBar";

export default function AllPlayers() {
    const [footballPlayers, setFootballPlayers] = useState([]);

    const columnsForAllPlayers = [
        {
            title: 'FullName',
            dataIndex: 'fullName',
        },
        {
            title: 'Amplua',
            dataIndex: 'amplua',
            filters: [
                {
                    text: 'GOALKEEPER',
                    value: 'GOALKEEPER',
                },
                {
                    text: 'DEFENDER',
                    value: 'DEFENDER',
                },
                {
                    text: 'MIDFIELDER',
                    value: 'MIDFIELDER',
                },
                {
                    text: 'FORWARD',
                    value: 'FORWARD',
                },
            ],
            onFilter: (value, record) => record.amplua.startsWith(value),
            filterSearch: true,
        },
        {
            title: 'Price',
            className: 'column-money',
            dataIndex: 'price',
            align: 'center',
        },
    ];

    const fetchPlayers = () =>
        getAllPlayers()
            .then(res => res.json())
            .then(data => {
                setFootballPlayers(data);
            })

    useEffect(() => {
        fetchPlayers();
    }, []);

    const renderFootballPlayers = () => {
        if (footballPlayers.length <= 0) {
            return <Empty/>;
        }
        return <Table
            dataSource = {footballPlayers}
            columns = {columnsForAllPlayers}
            bordered
            title={() => 'All Players'}
            rowKey={(footballPlayer) => JSON.stringify(footballPlayer)}
        />;
    }

    return (
        <>
            <SideBar />

            <Layout className="site-layout">
                <Header className="site-layout-background">
                    <h2>My Fantasy League</h2>
                </Header>
                <Content>
            <div style={{ padding: 24, minHeight: 360 }}>
                {renderFootballPlayers()}
            </div>
                </Content>
                <Footer className="site-layout-footer">Fantasy League by Oleg Skydan</Footer>
            </Layout>
        </>
    )
}
