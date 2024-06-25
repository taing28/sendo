import { Button, Col, Form, Input, Row } from "antd";
import { memo } from "react";
import logo from '../../assets/image/sendo-logo.png'
import '../../assets/css/style.css'
import { Container } from "react-bootstrap";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faBorderAll } from '@fortawesome/free-solid-svg-icons'
import { SearchOutlined } from '@ant-design/icons'

export const HeaderHomePage = memo(() => {
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
                        <Col span={2}>
                            <FontAwesomeIcon className="icon-header" icon={faBorderAll} />
                        </Col>
                        <Col span={22}>
                            <Form>
                                <div className="d-flex align-items-center justify-center">
                                        <Input placeholder="Search" />
                                        <Button>
                                            <SearchOutlined />
                                        </Button>
                                </div>
                            </Form>
                        </Col>
                    </Row>
                </Col>
                <Col span={4}>login</Col>
            </Row>
        </Container>
    )
})