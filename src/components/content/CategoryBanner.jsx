import { memo } from "react";
import { Container, Row } from "react-bootstrap";
import catConImg from '../../assets/image/cateCon.jpg'

export const CategoryBanner = memo(() => {
    const cateCon = [{ image: catConImg, name: 'Cate Con' }, { image: catConImg, name: 'Cate Con' }, { image: catConImg, name: 'Cate Con' }, { image: catConImg, name: 'Cate Con' }, { image: catConImg, name: 'Cate Con' }, { image: catConImg, name: 'Cate Con' },{ image: catConImg, name: 'Cate Con' },{ image: catConImg, name: 'Cate Con' },{ image: catConImg, name: 'Cate Con' },{ image: catConImg, name: 'Cate Con' },]

    return (
        <Container fluid className="bg-body ps-5 pe-5">
            {/* Category */}
            <Row>
                <ul className="d-flex justify-content-center">
                    {cateCon.map((value, index) => {
                        return (
                            <li key={index}>
                                <div className="card p-3" style={{width:'123px'}}>
                                    <img src={value.image} class="card-img-top" alt="Image"/>
                                        <div className="card-body text-center p-0">
                                            <h5 className="card-title">{value.name}</h5>
                                        </div>
                                </div>
                            </li>
                        )
                    })}
                </ul>
            </Row>
            {/* Advertising */}
            <Row>

            </Row>
        </Container>
    )
})