import React from 'react';
import { Button, Col, Form, Row } from 'react-bootstrap';

const AdminLogin = () => {
    return (
        <div>
            <Button as="button" variant="primary">
                Button as link
            </Button>
            <Form>
                <Row>
                    <Col>
                    <Form.Control placeholder="First name" />
                    </Col>
                    <Col>
                    <Form.Control placeholder="Last name" />
                    </Col>
                </Row>
            </Form>
        </div>
    );
};

export default AdminLogin;