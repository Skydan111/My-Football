import {useState, useEffect} from 'react';
import {getAllPlayers, getTeamSquad} from "../../client";
import {
    Breadcrumb,
    Empty,
    Table
} from "antd";

export default function MyTeam() {

    const [squad, setSquad] = useState([]);

    const columnsForSquad = [
        {
            title: 'FullName',
            dataIndex: 'fullName',
        },
        {
            title: 'Amplua',
            dataIndex: 'amplua',
        },
        {
            title: 'Price',
            className: 'column-money',
            dataIndex: 'price',
            align: 'center',
        },
    ];

    const fetchSquad = () =>
        getTeamSquad()
            .then(res => res.json())
            .then(data => {
                setSquad(data);
            })

    useEffect(() => {
        fetchSquad();
    }, []);

    const renderSquad = () => {
        if (squad.length <= 0) {
            return <Empty/>;
        }
        return <Table
            dataSource = {squad}
            columns = {columnsForSquad}
            bordered
            title={() => 'My Squad'}
            rowKey={(footballPlayer) => JSON.stringify(footballPlayer)}
        />;
    }

    return (
        <div>
            <Breadcrumb>
                <Breadcrumb.Item>
                    Oleg
                </Breadcrumb.Item>
                <Breadcrumb.Item>
                    Everton
                </Breadcrumb.Item>
            </Breadcrumb>
            <div style={{ padding: 24, minHeight: 360 }}>
                {renderSquad()}
            </div>
        </div>
    )
}