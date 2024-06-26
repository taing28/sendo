import { memo } from "react";
import { Nav } from "react-bootstrap";

export const CategoryNavbar = memo(() => {
    const cate = [{ cateName: 'Cho bạn' }, { cateName: 'Áo nữ' }, { cateName: 'Đồ dùng nhà bếp' }, { cateName: 'Vệ sinh, chăm sóc nhà cửa' }, { cateName: 'Đầm, váy' },]

    return (
        <Nav className="navbar-content justify-content-center" variant="underline" defaultActiveKey="/home">
            {cate.map((value, index) => {
                return (
                    <Nav.Item key={index}>
                        <Nav.Link eventKey={`link-${index}`}>{value.cateName}</Nav.Link>
                    </Nav.Item>
                )
            })}
        </Nav>
    )
})