import {useState, useEffect} from 'react';
import {getAllPlayers} from "../../client";
import {Breadcrumb, Empty, Table} from "antd";

export default function AllPlayers() {
    const [footballPlayers, setFootballPlayers] = useState([]);

    const columnsForAllPlayers = [
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
        <div>
            <Breadcrumb>
                <Breadcrumb.Item>
                    <h2>Everton</h2>
                </Breadcrumb.Item>
            </Breadcrumb>
            <div style={{ padding: 24, minHeight: 360 }}>
                {renderFootballPlayers()}
            </div>
        </div>
    )
}
