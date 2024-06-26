import { memo } from "react";
import { Container, Row } from "react-bootstrap";
import { ThunderboltTwoTone } from "@ant-design/icons"
import { Card } from "antd";
import Meta from "antd/es/card/Meta";

export const FlashSaleBanner = memo(() => {
    return (
        <Container className="pb-3 pt-2 bg-body mt-2 rounded">
            <h4><ThunderboltTwoTone />FLASH SALE</h4>
            <Row className="justify-content-center">
                <Card
                    hoverable
                    style={{
                        width: '160px',
                        margin: '2px',
                        height: 'fit-content'
                    }}
                    cover={<img style={{
                        height: '120px',
                        objectFit: 'cover',
                        objectPosition: 'top'}} alt="example" src="https://os.alipayobjects.com/rmsportal/QBnOOoLaAfKPirc.png" />}
                >
                <Meta title="Europe Street beat" description="www.instagram.com" />
            </Card>
            <Card
                    hoverable
                    style={{
                        width: '160px',
                        margin: '2px',
                        height: 'fit-content'
                    }}
                    cover={<img style={{
                        height: '120px',
                        objectFit: 'cover',
                        objectPosition: 'top'}} alt="example" src="https://os.alipayobjects.com/rmsportal/QBnOOoLaAfKPirc.png" />}
                >
                <Meta title="Europe Street beat" description="www.instagram.com" />
            </Card>
            <Card
                    hoverable
                    style={{
                        width: '160px',
                        margin: '2px',
                        height: 'fit-content'
                    }}
                    cover={<img style={{
                        height: '120px',
                        objectFit: 'cover',
                        objectPosition: 'top'}} alt="example" src="https://os.alipayobjects.com/rmsportal/QBnOOoLaAfKPirc.png" />}
                >
                <Meta title="Europe Street beat" description="www.instagram.com" />
            </Card>
        </Row>
        </Container >
    )
})