import {Drawer, Input, Col, Select, Form, Row, Button} from 'antd';
import {addNewUser} from "../client";
import {infoNotification} from "./Notification";

const {Option} = Select;

function UserDrawerForm({showDrawer, setShowDrawer}) {
    const onCLose = () => setShowDrawer(false);

    const onFinish = user => {
        addNewUser(user)
            .then(() => {
                console.log("user added")
                onCLose();
                infoNotification("Please confirm your email", 'Check your mailbox')
            })
    };

    const onFinishFailed = errorInfo => {
        alert(JSON.stringify(errorInfo, null, 2));
    };

    return <Drawer
        title="Create new player"
        width={720}
        onClose={onCLose}
        visible={showDrawer}
        bodyStyle={{paddingBottom: 80}}
        footer={
            <div
                style={{
                    textAlign: 'right',
                }}
            >
                <Button onClick={onCLose} style={{marginRight: 8}}>
                    Cancel
                </Button>
            </div>
        }
    >
        <Form layout="vertical"
              onFinishFailed={onFinishFailed}
              onFinish={onFinish}
              hideRequiredMark>
            <Row gutter={16}>
                <Col span={12}>
                    <Form.Item
                        name="firstName"
                        label="First Name"
                        rules={[{required: true, message: 'Please enter your first name'}]}
                    >
                        <Input placeholder="Please enter your first name"/>
                    </Form.Item>
                </Col>
                <Col span={12}>
                    <Form.Item
                        name="lastName"
                        label="Last Name"
                        rules={[{required: true, message: 'Please enter your last name'}]}
                    >
                        <Input placeholder="Please enter your last name"/>
                    </Form.Item>
                </Col>
                <Col span={12}>
                    <Form.Item
                        name="email"
                        label="Email"
                        rules={[{required: true, message: 'Please enter your email'}]}
                    >
                        <Input placeholder="Please enter your email"/>
                    </Form.Item>
                </Col>
            </Row>
            <Row gutter={16}>
                <Col span={12}>
                    <Form.Item
                        name="password"
                        label="Password"
                        rules={[{required: true, message: 'Please enter your password'}]}
                    >
                        <Input placeholder="Please enter your password"/>
                    </Form.Item>
                </Col>
            </Row>
            <Row>
                <Col span={12}>
                    <Form.Item >
                        <Button type="primary" htmlType="submit">
                            Submit
                        </Button>
                    </Form.Item>
                </Col>
            </Row>
        </Form>
    </Drawer>
}

export default UserDrawerForm;