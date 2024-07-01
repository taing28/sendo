import React, { useEffect, useRef, useState } from 'react';
import { Breadcrumb, Button, Carousel, Image, Input, Layout, theme } from 'antd';
import { memo } from "react";
import { Col, Container, Row } from 'react-bootstrap';
import { LeftOutlined, RightOutlined } from '@ant-design/icons'

const { Content } = Layout;


export const ProductDetailContent = memo(() => {
    const imageRef = useRef(null);
    const [selectedIndex, setSelectedIndex] = useState(0)
    const [selectedSize, setSelectedSize] = useState(null);
    const [selectedColor, setSelectedColor] = useState(null);
    const [quantity, setQuantity] = useState(1);

    const handleSizeClick = (size) => {
        setSelectedSize(size);
    };

    const handleColorClick = (color) => {
        setSelectedColor(color);
    };

    const [data, setData] = useState(
        { url: ['https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png', 'https://gw.alipayobjects.com/zos/antfincdn/LlvErxo8H9/photo-1503185912284-5271ff81b9a8.webp', 'https://imgv3.fotor.com/images/slider-image/A-clear-close-up-photo-of-a-woman.jpg'], name: 'Ten', price: 100000, quantity: 5 }
    )

    const clickHandler = (index) => {
        setSelectedIndex(index)
        imageRef.current.goTo(index)
    }

    const addHandler = () => {
        setQuantity(quantity => quantity + 1)
    }
    const minusHandler = () => {
        setQuantity(quantity => quantity - 1)
    }

    const {
        token: { colorBgContainer, borderRadiusLG },
    } = theme.useToken();

    useEffect(() => {
        if (quantity < 1) {
            setQuantity(1)
        }
        if (quantity > 20) {
            setQuantity(20)
        }
    }, [quantity])

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
                <Content style={{ padding: '0 24px', minHeight: 280 }}>
                    <Container className="mt-3 mb-3">
                        <Row>
                            <Col className="col-md-5">
                                <Carousel className='product-thumb' ref={imageRef}>
                                    {data.url.map((value, index) => {
                                        return (
                                            <Image
                                                width={450}
                                                src={`${value}`}
                                            />
                                        )
                                    })}
                                </Carousel>

                                <div className="product-list">
                                    <LeftOutlined className='prev' />
                                    <div className='d-flex' style={{ flexWrap: 'nowrap' }}>
                                        {data.url.map((value, index) => {
                                            return (
                                                <img onClick={() => clickHandler(index)} className={`product-list-detail p-1 ${selectedIndex === index ? 'selected' : ''}`} key={index} src={`${value}`} />
                                            )
                                        })}
                                    </div>
                                    <RightOutlined className='next' />
                                </div>
                            </Col>

                            <Col>
                                <div style={{ textAlign: 'start' }}>
                                    <div>
                                        <div className='title-detail'>
                                            <h1>{data.name}</h1>
                                        </div>
                                        <div className='price-detail'>
                                            <span>{data.price}đ</span>
                                        </div>
                                    </div>
                                    <div className='spacing'></div>
                                    <hr />
                                    <div style={{ lineHeight: 'normal' }}>
                                        <Row className='row'>
                                            <Col className='col-md-3'>
                                                <Row>
                                                    <Col className='col-md-12'>Chon mau sac</Col>
                                                    <Col style={{ fontWeight: 'bold' }} className='col-md-12'>{selectedColor}</Col>
                                                </Row>
                                            </Col>
                                            <Col className='col-md-5'>
                                                <Button className={selectedColor === 'Hong PJ' ? 'selectedBtn property' : 'property'}
                                                    onClick={() => handleColorClick('Hong PJ')}>
                                                    Hong PJ
                                                </Button>
                                                <Button className={selectedColor === 'Nau PJ' ? 'selectedBtn property' : 'property'}
                                                    onClick={() => handleColorClick('Nau PJ')}>
                                                    Nau PJ
                                                </Button>
                                            </Col>
                                        </Row>

                                        <Row className='row'>
                                            <Col className='col-md-3'>
                                                <Row>
                                                    <Col className='col-md-12'>Chon kich thuoc</Col>
                                                    <Col style={{ fontWeight: 'bold' }} className='col-md-12'>{selectedSize}</Col>
                                                </Row>
                                            </Col>
                                            <Col className='col-md-5'>
                                                <Button
                                                    className={selectedSize === 'S' ? 'selectedBtn property' : 'property'}
                                                    onClick={() => handleSizeClick('S')}
                                                >
                                                    S
                                                </Button>
                                                <Button
                                                    className={selectedSize === 'M' ? 'selectedBtn property' : 'property'}
                                                    onClick={() => handleSizeClick('M')}
                                                >
                                                    M
                                                </Button>
                                                <Button
                                                    className={selectedSize === 'L' ? 'selectedBtn property' : 'property'}
                                                    onClick={() => handleSizeClick('L')}
                                                >
                                                    L
                                                </Button>
                                                <Button
                                                    className={selectedSize === 'XL' ? 'selectedBtn property' : 'property'}
                                                    onClick={() => handleSizeClick('XL')}
                                                >
                                                    XL
                                                </Button>
                                            </Col>
                                        </Row>


                                        <Row>
                                            <Col className='col-md-3'>
                                                Chon so luong
                                            </Col>
                                            <Col>
                                                <Button className='quantity-btn property' onClick={minusHandler} disabled={quantity <= 1}>-</Button>
                                                <Input
                                                    style={{ width: '44px' }}
                                                    defaultValue={1}
                                                    onChange={(e) => setQuantity(e.target.value)}
                                                    value={quantity}
                                                />
                                                <Button className='quantity-btn property' onClick={addHandler} disabled={quantity >= 20}>+</Button>
                                            </Col>
                                        </Row>
                                    </div>
                                    <Row>
                                        <Col className='col-md-6'>
                                            <button className='w-100 btn btn-secondary' style={{lineHeight:'2.3'}}>Thêm vào giỏ hàng</button>
                                        </Col>
                                        <Col className='col-md-6'>
                                            <button className='w-100 btn btn-danger' style={{lineHeight:'2.3'}}>Mua ngay</button>
                                        </Col>
                                    </Row>
                                </div>
                            </Col>
                        </Row>
                    </Container>
                </Content>
            </Layout>
        </Container>
    )
})