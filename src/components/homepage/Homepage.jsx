import { memo } from "react";
import Nav from 'react-bootstrap/Nav';
import { Flex, Layout } from "antd";
import { Content, Footer, Header } from "antd/es/layout/layout";
import { HeaderHomePage } from "../header/HeaderHomePage";

export const Homepage = memo(() => {
  const headerStyle = {
    textAlign: 'center',
    color: '#fff',
    height: 'fit-content',
    lineHeight: '64px',
    backgroundColor: '#ee2624',
  };
  const contentStyle = {
    textAlign: 'center',
    minHeight: 120,
    lineHeight: '120px',
    color: '#fff',
    backgroundColor: '#fff',
  };
  const footerStyle = {
    textAlign: 'center',
    color: '#fff',
    backgroundColor: '#4096ff',
  };
  const layoutStyle = {
    borderRadius: 8,
    overflow: 'hidden',
    width: 'calc(100%)',
    maxWidth: 'calc(100%)',
  };
  return (
    <Flex gap="middle" wrap>
      <Layout style={layoutStyle}>
        <Header style={headerStyle}><HeaderHomePage /></Header>
        <Content style={contentStyle}>
              <Nav className="navbar-content justify-content-center" variant="underline" defaultActiveKey="/home">
                <Nav.Item>
                  <Nav.Link href="#">Cho bạn</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                  <Nav.Link eventKey="link-1">Áo nữ</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                  <Nav.Link eventKey="link-2">Đồ dùng nhà bếp</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                  <Nav.Link eventKey="link-3">Vệ sinh, chăm sóc nhà cửa</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                  <Nav.Link eventKey="link-4">Đầm, váy</Nav.Link>
                </Nav.Item>
              </Nav>
          <h1 style={{color:'#ccc'}}>Content</h1>
        </Content>
        <Footer style={footerStyle}>Footer</Footer>
      </Layout>
    </Flex>
  )
})