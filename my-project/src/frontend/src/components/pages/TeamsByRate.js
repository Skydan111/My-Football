import {useState, useEffect} from 'react';
import {getTeamsByRate} from "../../client";
import {Table} from "antd";

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
            dataSource = {teamsByRate}
            columns = {columnsForTable}
            rowKey={(team) => JSON.stringify(team)}
        />
    }

    return (
            <div style={{ padding: 24, minHeight: 360 }}>
                {renderTeamsByRate()}
            </div>
    )
}