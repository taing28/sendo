import { memo } from "react";
import { CategoryBanner } from "./CategoryBanner";
import { CategoryNavbar } from "./CategoryNavbar";
import { FlashSaleBanner } from "./FlashSaleBanner";
import { Card } from "antd";
import Meta from "antd/es/card/Meta";
import { Col, Container, Row } from "react-bootstrap";

export const HomeContent = memo(() => {
    return (
        <div style={{ color: 'black' }}>
            <CategoryNavbar />
            <CategoryBanner />
            <FlashSaleBanner />

            <Container className="mt-3 mb-3">
                <Row>
                    <Col className="col-md-2">
                        <Card
                            hoverable
                            style={{
                                width: 240,
                            }}
                            cover={<img alt="example" src="https://os.alipayobjects.com/rmsportal/QBnOOoLaAfKPirc.png" />}
                        >
                            <Meta title="Europe Street beat" description="www.instagram.com" />
                        </Card>
                    </Col>
                </Row>
            </Container>

        </div>
    )
})