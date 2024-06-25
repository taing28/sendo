import { Button, Col, Form, Input, Popover, Row } from "antd";
import { memo } from "react";
import logo from '../../assets/image/sendo-logo.png'
import '../../assets/css/style.css'
import { Container } from "react-bootstrap";
import { SearchOutlined, ShoppingOutlined, AppstoreAddOutlined } from '@ant-design/icons'

export const HeaderHomePage = memo(() => {
    const contentCategory = (
        <div>
            <p>Content</p>
            <p>Content</p>
        </div>
    );

    const contentSearch = (
        <div>
            <p>item 1</p>
            <p>item 1</p>
        </div>
    )

    return (
        <Container>
            <Row>
                <Col span={2}>
                    <div>
                        <img className="image-logo" src={logo} alt="Logo" />
                    </div>
                </Col>
                <Col span={18}>
                    <Row>
                        <Col span={2} style={{ lineHeight: '64px' }}>
                            <Popover content={contentCategory} title="Tieu de" trigger="hover">
                                <AppstoreAddOutlined className="icon-header" />
                            </Popover>
                        </Col>
                        <Col span={22}>
                            <Form>
                                <Row>
                                    <Col span={22} style={{ lineHeight: '64px' }}>
                                        <Popover content={contentSearch} title="Title" trigger="focus">
                                            <Input placeholder="Search" />
                                        </Popover>
                                    </Col>
                                    <Col span={2} style={{ lineHeight: '64px' }}>
                                        <Button style={{ transform: 'translateY(-5%)' }}>
                                            <SearchOutlined />
                                        </Button>
                                    </Col>
                                </Row>

                            </Form>
                        </Col>
                    </Row>
                </Col>
                <Col span={4}>
                    <Row>
                        <Col span={12}>
                            <ShoppingOutlined className="icon-header" />
                        </Col>
                        <Col span={12}>
                            <Button style={{ fontWeight: 'bold' }}>Đăng nhập</Button>
                        </Col>
                    </Row>
                </Col>
            </Row>
        </Container>
    )
})