import React from 'react';
import { Breadcrumb, Card, Layout, theme } from 'antd';
import { memo } from "react";
import { Col, Container, Row } from 'react-bootstrap';
import { CategorySider } from './CategorySider';
import Meta from 'antd/es/card/Meta';
import { Link } from 'react-router-dom';

const { Content } = Layout;



export const CategoryContent = memo(() => {

    const {
        token: { colorBgContainer, borderRadiusLG },
    } = theme.useToken();

    return (
        <Container>
            <Breadcrumb style={{ margin: '16px 0' }}>
                <Breadcrumb.Item>Home</Breadcrumb.Item>
                <Breadcrumb.Item>List</Breadcrumb.Item>
                <Breadcrumb.Item>App</Breadcrumb.Item>
            </Breadcrumb>

            <Layout
                style={{ padding: '24px 0', background: colorBgContainer, borderRadius: borderRadiusLG }}
            >
                <CategorySider />
                <Content style={{ padding: '0 24px', minHeight: 280 }}>
                    <Container className="mt-3 mb-3">
                        <Row>
                            <Col className="col-md-2">
                            <Link href="/product-detail/ten">
                                <Card
                                    hoverable
                                    style={{
                                        width: 240,
                                    }}
                                    cover={<img alt="example" src="https://os.alipayobjects.com/rmsportal/QBnOOoLaAfKPirc.png" />}
                                >
                                    <Meta title="Name" description="Description" />
                                    <h6 className='p-2'>Price</h6>
                                </Card>
                            </Link>
                            </Col>
                        </Row>
                    </Container>
                </Content>
            </Layout>
        </Container>
    )
})