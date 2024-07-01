import { memo } from "react";
import { Col, Container, Row } from "react-bootstrap";
import catConImg from '../../../assets/image/cateCon.jpg'
import adLeft from '../../../assets/image/advertise_left.jpg'
import adRight from '../../../assets/image/advertise_right.jpg'
import adMid from '../../../assets/image/advertise_middle.jpg'
import { Link } from "react-router-dom";

export const CategoryBanner = memo(() => {
    const cateCon = [{ image: catConImg, name: 'Cate Con' }, { image: catConImg, name: 'Cate Con' }, { image: catConImg, name: 'Cate Con' }, { image: catConImg, name: 'Cate Con' }, { image: catConImg, name: 'Cate Con' }, { image: catConImg, name: 'Cate Con' }, { image: catConImg, name: 'Cate Con' }, { image: catConImg, name: 'Cate Con' }, { image: catConImg, name: 'Cate Con' }, { image: catConImg, name: 'Cate Con' },]

    return (
        <Container fluid className="bg-body ps-5 pe-5 pb-5">
            {/* Category */}
            <Row>
                <ul className="d-flex justify-content-center" style={{ listStyle: 'none' }} >
                    {cateCon.map((value, index) => {
                        return (
                            <li key={index}>
                                <Link to={'/category'} style={{ textDecoration: 'none' }}>
                                    <div className="card p-3 border-0" style={{ width: '120px' }}>
                                        <img src={value.image} class="card-img-top cate-image" alt="Cate con" />
                                        <div className="card-body text-center p-0">
                                            <h5 className="card-title">{value.name}</h5>
                                        </div>
                                    </div>
                                </Link>
                            </li>
                        )
                    })}
                </ul>
            </Row>
            {/* Advertising */}
            <Row>
                <Col className="col-sm-6 col-lg-3" style={{ margin: 'auto' }}>
                    <a href="#">
                        <img className="ad-image" src={adLeft} alt="Left Img" />
                    </a>
                </Col>
                <Col className="col-sm-12 col-lg-6" style={{ margin: 'auto' }}>
                    <a href="#">
                        <img className="ad-image" src={adMid} alt="Left Img" />
                    </a>
                </Col>
                <Col className="col-sm-6 col-lg-3" style={{ margin: 'auto' }}>
                    <a href="#">
                        <img className="ad-image" src={adRight} alt="Left Img" />
                    </a>
                </Col>
            </Row>
        </Container>
    )
})