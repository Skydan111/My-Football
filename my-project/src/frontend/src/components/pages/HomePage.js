import {Button} from "antd";
import {UserAddOutlined} from "@ant-design/icons";
import {useState} from "react";
import UserDrawerForm from "../UserDrawerForm";

export default function HomePage() {
    const [showDrawer, setShowDrawer] = useState(false);

    return <>
        <UserDrawerForm
            showDrawer={showDrawer}
            setShowDrawer={setShowDrawer}
        />
        <Button
            onClick={() => setShowDrawer(!showDrawer)}
            type="primary" icon={<UserAddOutlined />} size='large'>
            Registration
        </Button>
    </>
}