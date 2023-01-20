import {useState, useEffect} from 'react';
import {getTeamsByRate} from "../../client";
import {Layout, Table} from "antd";
import {Content, Footer, Header} from "antd/es/layout/layout";
import SideBar from "../SideBar";

export default function TeamsByRate() {
    const [teamsByRate, setTeamsByRate] = useState([]);

    const columnsForTable = [
        {
            title: 'Team Name',
            dataIndex: 'teamName',
        },
        {
            title: 'Rating',
            dataIndex: 'teamRate',
            sorter: {
                compare: (a, b) => a.teamRate - b.teamRate,
            },
        },
    ];

    const fetchTeamsByRate = () =>
        getTeamsByRate()
            .then(res => res.json())
            .then(data => {
                setTeamsByRate(data);
            })

    useEffect(() => {
        fetchTeamsByRate();
    }, []);

    const renderTeamsByRate = () => {
        return <Table
            dataSource={teamsByRate}
            columns={columnsForTable}
            rowKey={(team) => JSON.stringify(team)}
        />
    }

    return (
        <>
            <SideBar/>
            <Layout className="site-layout">
                <Header className="site-layout-background">
                    <h2>My Fantasy League</h2>
                </Header>
                <Content>
                    <div style={{padding: 24, minHeight: 360}}>
                        {renderTeamsByRate()}
                    </div>
                </Content>
                <Footer className="site-layout-footer">Fantasy League by Oleg Skydan</Footer>
            </Layout>
        </>
    )
}