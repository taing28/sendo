import { memo } from "react";
import { Flex, Layout } from "antd";
import { Content, Footer, Header } from "antd/es/layout/layout";
import { HeaderHomePage } from "../header/HeaderHomePage";

export const Homepage = memo(() => {
    const headerStyle = {
        textAlign: 'center',
        color: '#fff',
        height: 'fit-content',
        // paddingInline: '66px',
        lineHeight: '64px',
        backgroundColor: '#ee2624',
      };
      const contentStyle = {
        textAlign: 'center',
        minHeight: 120,
        lineHeight: '120px',
        color: '#fff',
        backgroundColor: '#0958d9',
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
          <Header style={headerStyle}><HeaderHomePage/></Header>
          <Content style={contentStyle}>
            Content
          </Content>
          <Footer style={footerStyle}>Footer</Footer>
        </Layout>
      </Flex>
    )
})